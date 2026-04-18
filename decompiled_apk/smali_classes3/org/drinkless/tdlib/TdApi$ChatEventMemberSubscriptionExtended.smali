.class public Lorg/drinkless/tdlib/TdApi$ChatEventMemberSubscriptionExtended;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMemberSubscriptionExtended"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x44054ffe


# instance fields
.field public newStatus:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

.field public oldStatus:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36080
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 36081
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatMemberStatus;Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatMemberStatus"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
    .param p4, "chatMemberStatus2"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 36069
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 36070
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberSubscriptionExtended;->userId:J

    .line 36071
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberSubscriptionExtended;->oldStatus:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 36072
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberSubscriptionExtended;->newStatus:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 36073
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36077
    const v0, -0x44054ffe

    return v0
.end method
