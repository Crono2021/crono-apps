.class public Lorg/drinkless/tdlib/TdApi$CollectibleItemTypePhoneNumber;
.super Lorg/drinkless/tdlib/TdApi$CollectibleItemType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CollectibleItemTypePhoneNumber"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4ae0e142


# instance fields
.field public phoneNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10932
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CollectibleItemType;-><init>()V

    .line 10933
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 10923
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CollectibleItemType;-><init>()V

    .line 10924
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CollectibleItemTypePhoneNumber;->phoneNumber:Ljava/lang/String;

    .line 10925
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10929
    const v0, 0x4ae0e142    # 7368865.0f

    return v0
.end method
