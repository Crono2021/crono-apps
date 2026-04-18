.class public Lorg/drinkless/tdlib/TdApi$MessageAutoDeleteTime;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageAutoDeleteTime"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x758b0715


# instance fields
.field public time:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16206
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16207
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16197
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16198
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageAutoDeleteTime;->time:I

    .line 16199
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16203
    const v0, 0x758b0715

    return v0
.end method
