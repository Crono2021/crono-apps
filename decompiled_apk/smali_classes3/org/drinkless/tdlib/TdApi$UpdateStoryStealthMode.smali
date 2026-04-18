.class public Lorg/drinkless/tdlib/TdApi$UpdateStoryStealthMode;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateStoryStealthMode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6ff7bd1a


# instance fields
.field public activeUntilDate:I

.field public cooldownUntilDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34988
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34989
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 34978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34979
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryStealthMode;->activeUntilDate:I

    .line 34980
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryStealthMode;->cooldownUntilDate:I

    .line 34981
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34985
    const v0, 0x6ff7bd1a

    return v0
.end method
