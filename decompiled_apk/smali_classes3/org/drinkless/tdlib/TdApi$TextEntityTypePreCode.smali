.class public Lorg/drinkless/tdlib/TdApi$TextEntityTypePreCode;
.super Lorg/drinkless/tdlib/TdApi$TextEntityType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextEntityTypePreCode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x38588555


# instance fields
.field public language:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextEntityType;-><init>()V

    .line 21279
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 21269
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextEntityType;-><init>()V

    .line 21270
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TextEntityTypePreCode;->language:Ljava/lang/String;

    .line 21271
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21275
    const v0, -0x38588555

    return v0
.end method
