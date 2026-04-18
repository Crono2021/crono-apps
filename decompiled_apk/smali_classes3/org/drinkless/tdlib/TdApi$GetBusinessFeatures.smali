.class public Lorg/drinkless/tdlib/TdApi$GetBusinessFeatures;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBusinessFeatures"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessFeatures;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3b6f9fff


# instance fields
.field public source:Lorg/drinkless/tdlib/TdApi$BusinessFeature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12210
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12211
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessFeature;)V
    .locals 0
    .param p1, "businessFeature"    # Lorg/drinkless/tdlib/TdApi$BusinessFeature;

    .line 12201
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12202
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetBusinessFeatures;->source:Lorg/drinkless/tdlib/TdApi$BusinessFeature;

    .line 12203
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12207
    const v0, -0x3b6f9fff    # -1155.0001f

    return v0
.end method
