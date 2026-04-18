.class public Lorg/drinkless/tdlib/TdApi$EditChatSubscriptionInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditChatSubscriptionInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatInviteLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x38bbba2d


# instance fields
.field public chatId:J

.field public inviteLink:Ljava/lang/String;

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36719
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;

    .line 36707
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36708
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditChatSubscriptionInviteLink;->chatId:J

    .line 36709
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EditChatSubscriptionInviteLink;->inviteLink:Ljava/lang/String;

    .line 36710
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EditChatSubscriptionInviteLink;->name:Ljava/lang/String;

    .line 36711
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36715
    const v0, -0x38bbba2d

    return v0
.end method
