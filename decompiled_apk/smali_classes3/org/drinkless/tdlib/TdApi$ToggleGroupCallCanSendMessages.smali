.class public Lorg/drinkless/tdlib/TdApi$ToggleGroupCallCanSendMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleGroupCallCanSendMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x24cdccb4


# instance fields
.field public canSendMessages:Z

.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33248
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33249
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 33238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33239
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallCanSendMessages;->groupCallId:I

    .line 33240
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallCanSendMessages;->canSendMessages:Z

    .line 33241
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33245
    const v0, -0x24cdccb4

    return v0
.end method
