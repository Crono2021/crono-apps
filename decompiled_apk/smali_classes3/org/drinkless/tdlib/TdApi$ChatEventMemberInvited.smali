.class public Lorg/drinkless/tdlib/TdApi$ChatEventMemberInvited;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMemberInvited"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38d7bfc9


# instance fields
.field public status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23885
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatMemberStatus;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatMemberStatus"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 23874
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23875
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberInvited;->userId:J

    .line 23876
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMemberInvited;->status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 23877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23881
    const v0, 0x38d7bfc9

    return v0
.end method
