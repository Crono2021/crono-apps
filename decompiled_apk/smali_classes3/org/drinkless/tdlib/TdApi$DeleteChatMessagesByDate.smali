.class public Lorg/drinkless/tdlib/TdApi$DeleteChatMessagesByDate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteChatMessagesByDate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x61bb1f41


# instance fields
.field public chatId:J

.field public maxDate:I

.field public minDate:I

.field public revoke:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43015
    return-void
.end method

.method public constructor <init>(JIIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "z8"    # Z

    .line 43002
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43003
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatMessagesByDate;->chatId:J

    .line 43004
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatMessagesByDate;->minDate:I

    .line 43005
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatMessagesByDate;->maxDate:I

    .line 43006
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatMessagesByDate;->revoke:Z

    .line 43007
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43011
    const v0, -0x61bb1f41    # -1.042263E-20f

    return v0
.end method
