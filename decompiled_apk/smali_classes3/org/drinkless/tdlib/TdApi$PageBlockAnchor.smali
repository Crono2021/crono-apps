.class public Lorg/drinkless/tdlib/TdApi$PageBlockAnchor;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockAnchor"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x31f2c850


# instance fields
.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17142
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17143
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 17133
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17134
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockAnchor;->name:Ljava/lang/String;

    .line 17135
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17139
    const v0, -0x31f2c850

    return v0
.end method
