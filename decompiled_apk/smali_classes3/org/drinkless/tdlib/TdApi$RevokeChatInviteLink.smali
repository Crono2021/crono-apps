.class public Lorg/drinkless/tdlib/TdApi$RevokeChatInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RevokeChatInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatInviteLinks;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2e48aa57


# instance fields
.field public chatId:J

.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30408
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30409
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 30398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30399
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$RevokeChatInviteLink;->chatId:J

    .line 30400
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$RevokeChatInviteLink;->inviteLink:Ljava/lang/String;

    .line 30401
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30405
    const v0, -0x2e48aa57

    return v0
.end method
