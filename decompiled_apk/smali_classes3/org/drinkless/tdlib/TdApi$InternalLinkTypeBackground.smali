.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBackground;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeBackground"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xb0d2908


# instance fields
.field public backgroundName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15235
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15225
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15226
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBackground;->backgroundName:Ljava/lang/String;

    .line 15227
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15231
    const v0, 0xb0d2908

    return v0
.end method
