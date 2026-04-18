.class public Lorg/drinkless/tdlib/TdApi$AccountTtl;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AccountTtl"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4ef23284


# instance fields
.field public days:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8592
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8593
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 8583
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8584
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AccountTtl;->days:I

    .line 8585
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8589
    const v0, 0x4ef23284

    return v0
.end method
