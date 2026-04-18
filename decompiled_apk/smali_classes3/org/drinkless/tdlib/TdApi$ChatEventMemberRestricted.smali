.class public Lorg/drinkless/tdlib/TdApi$ChatEventMemberRestricted;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMemberRestricted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5f951e05


# instance fields
.field public memberId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public newStatus:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

.field public oldStatus:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 36059
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "chatMemberStatus"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
    .param p3, "chatMemberStatus2"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 36047
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 36048
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberRestricted;->memberId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 36049
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberRestricted;->oldStatus:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 36050
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberRestricted;->newStatus:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 36051
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36055
    const v0, 0x5f951e05

    return v0
.end method
