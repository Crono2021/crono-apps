.class public Lorg/drinkless/tdlib/TdApi$GetChatInviteLinkMembers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatInviteLinkMembers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMembers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6704ed3c


# instance fields
.field public chatId:J

.field public inviteLink:Ljava/lang/String;

.field public limit:I

.field public offsetMember:Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;

.field public onlyWithExpiredSubscription:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47332
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47333
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;ZLorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z
    .param p5, "chatInviteLinkMember"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;
    .param p6, "i9"    # I

    .line 47319
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47320
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinkMembers;->chatId:J

    .line 47321
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinkMembers;->inviteLink:Ljava/lang/String;

    .line 47322
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinkMembers;->onlyWithExpiredSubscription:Z

    .line 47323
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinkMembers;->offsetMember:Lorg/drinkless/tdlib/TdApi$ChatInviteLinkMember;

    .line 47324
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinkMembers;->limit:I

    .line 47325
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47329
    const v0, 0x6704ed3c

    return v0
.end method
