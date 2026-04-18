.class public Lorg/drinkless/tdlib/TdApi$StarSubscriptionTypeChannel;
.super Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarSubscriptionTypeChannel"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3d65490b


# instance fields
.field public canReuse:Z

.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;-><init>()V

    .line 32329
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "str"    # Ljava/lang/String;

    .line 32318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;-><init>()V

    .line 32319
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptionTypeChannel;->canReuse:Z

    .line 32320
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptionTypeChannel;->inviteLink:Ljava/lang/String;

    .line 32321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32325
    const v0, -0x3d65490b

    return v0
.end method
