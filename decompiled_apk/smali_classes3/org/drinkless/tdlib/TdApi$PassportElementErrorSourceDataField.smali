.class public Lorg/drinkless/tdlib/TdApi$PassportElementErrorSourceDataField;
.super Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementErrorSourceDataField"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1265a318


# instance fields
.field public fieldName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;-><init>()V

    .line 17449
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 17439
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;-><init>()V

    .line 17440
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementErrorSourceDataField;->fieldName:Ljava/lang/String;

    .line 17441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17445
    const v0, -0x1265a318

    return v0
.end method
