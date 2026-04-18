.class public Lorg/drinkless/tdlib/TdApi$ChatInviteLinkSubscriptionInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatInviteLinkSubscriptionInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38cf7368


# instance fields
.field public canReuse:Z

.field public formId:J

.field public pricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36169
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;ZJ)V
    .locals 0
    .param p1, "starSubscriptionPricing"    # Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;
    .param p2, "z8"    # Z
    .param p3, "j5"    # J

    .line 36157
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36158
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkSubscriptionInfo;->pricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;

    .line 36159
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkSubscriptionInfo;->canReuse:Z

    .line 36160
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkSubscriptionInfo;->formId:J

    .line 36161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36165
    const v0, 0x38cf7368

    return v0
.end method
