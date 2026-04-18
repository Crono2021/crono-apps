.class public Lorg/drinkless/tdlib/TdApi$ProxyTypeMtproto;
.super Lorg/drinkless/tdlib/TdApi$ProxyType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProxyTypeMtproto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x751ce003


# instance fields
.field public secret:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17970
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ProxyType;-><init>()V

    .line 17971
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 17961
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ProxyType;-><init>()V

    .line 17962
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ProxyTypeMtproto;->secret:Ljava/lang/String;

    .line 17963
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17967
    const v0, -0x751ce003

    return v0
.end method
