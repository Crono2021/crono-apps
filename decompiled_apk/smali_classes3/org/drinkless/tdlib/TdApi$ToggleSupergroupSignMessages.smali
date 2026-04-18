.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupSignMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupSignMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x221c1fcb


# instance fields
.field public showMessageSender:Z

.field public signMessages:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41252
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41253
    return-void
.end method

.method public constructor <init>(JZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 41241
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41242
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupSignMessages;->supergroupId:J

    .line 41243
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupSignMessages;->signMessages:Z

    .line 41244
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupSignMessages;->showMessageSender:Z

    .line 41245
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41249
    const v0, 0x221c1fcb

    return v0
.end method
