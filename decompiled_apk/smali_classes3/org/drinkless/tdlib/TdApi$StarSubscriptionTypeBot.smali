.class public Lorg/drinkless/tdlib/TdApi$StarSubscriptionTypeBot;
.super Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarSubscriptionTypeBot"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xd78ddd2


# instance fields
.field public invoiceLink:Ljava/lang/String;

.field public isCanceledByBot:Z

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45366
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;-><init>()V

    .line 45367
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;Ljava/lang/String;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p4, "str2"    # Ljava/lang/String;

    .line 45354
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarSubscriptionType;-><init>()V

    .line 45355
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptionTypeBot;->isCanceledByBot:Z

    .line 45356
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptionTypeBot;->title:Ljava/lang/String;

    .line 45357
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptionTypeBot;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 45358
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptionTypeBot;->invoiceLink:Ljava/lang/String;

    .line 45359
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45363
    const v0, 0xd78ddd2

    return v0
.end method
