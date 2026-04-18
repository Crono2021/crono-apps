.class public Lorg/drinkless/tdlib/TdApi$ChatMember;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6d12e175


# instance fields
.field public inviterUserId:J

.field public joinedChatDate:I

.field public memberId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42775
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;JILorg/drinkless/tdlib/TdApi$ChatMemberStatus;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "j5"    # J
    .param p4, "i9"    # I
    .param p5, "chatMemberStatus"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 42762
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42763
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMember;->memberId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 42764
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ChatMember;->inviterUserId:J

    .line 42765
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatMember;->joinedChatDate:I

    .line 42766
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ChatMember;->status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 42767
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42771
    const v0, 0x6d12e175

    return v0
.end method
