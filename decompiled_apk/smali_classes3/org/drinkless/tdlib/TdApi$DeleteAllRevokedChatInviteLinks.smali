.class public Lorg/drinkless/tdlib/TdApi$DeleteAllRevokedChatInviteLinks;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteAllRevokedChatInviteLinks"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x424816da


# instance fields
.field public chatId:J

.field public creatorUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24905
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 24894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24895
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteAllRevokedChatInviteLinks;->chatId:J

    .line 24896
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteAllRevokedChatInviteLinks;->creatorUserId:J

    .line 24897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24901
    const v0, 0x424816da

    return v0
.end method
