.class public Lorg/drinkless/tdlib/TdApi$AffiliateTypeChannel;
.super Lorg/drinkless/tdlib/TdApi$AffiliateType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AffiliateTypeChannel"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x28c41797


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AffiliateType;-><init>()V

    .line 8755
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 8745
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AffiliateType;-><init>()V

    .line 8746
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AffiliateTypeChannel;->chatId:J

    .line 8747
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8751
    const v0, -0x28c41797

    return v0
.end method
