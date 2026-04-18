.class public Lorg/drinkless/tdlib/TdApi$HttpUrl;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HttpUrl"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x78488a5a


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14244
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 14245
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14235
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 14236
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$HttpUrl;->url:Ljava/lang/String;

    .line 14237
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14241
    const v0, -0x78488a5a

    return v0
.end method
