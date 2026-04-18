.class public Lorg/drinkless/tdlib/TdApi$TestInt;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestInt"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2242d3f7


# instance fields
.field public value:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21042
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21043
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 21033
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21034
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$TestInt;->value:I

    .line 21035
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21039
    const v0, -0x2242d3f7    # -1.70391E18f

    return v0
.end method
