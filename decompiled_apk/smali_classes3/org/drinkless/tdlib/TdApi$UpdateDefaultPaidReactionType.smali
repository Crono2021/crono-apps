.class public Lorg/drinkless/tdlib/TdApi$UpdateDefaultPaidReactionType;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateDefaultPaidReactionType"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x246dd47


# instance fields
.field public type:Lorg/drinkless/tdlib/TdApi$PaidReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21675
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PaidReactionType;)V
    .locals 0
    .param p1, "paidReactionType"    # Lorg/drinkless/tdlib/TdApi$PaidReactionType;

    .line 21665
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21666
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateDefaultPaidReactionType;->type:Lorg/drinkless/tdlib/TdApi$PaidReactionType;

    .line 21667
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21671
    const v0, 0x246dd47

    return v0
.end method
