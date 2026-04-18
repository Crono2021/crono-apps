.class public Lorg/drinkless/tdlib/TdApi$StatisticalGraphAsync;
.super Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StatisticalGraphAsync"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x19fb2b9f


# instance fields
.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StatisticalGraph;-><init>()V

    .line 20239
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20229
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StatisticalGraph;-><init>()V

    .line 20230
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StatisticalGraphAsync;->token:Ljava/lang/String;

    .line 20231
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20235
    const v0, 0x19fb2b9f

    return v0
.end method
