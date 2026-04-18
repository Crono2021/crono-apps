.class public Lorg/drinkless/tdlib/TdApi$UpdateBusinessConnection;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateBusinessConnection"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x79cd0b8a


# instance fields
.field public connection:Lorg/drinkless/tdlib/TdApi$BusinessConnection;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21585
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessConnection;)V
    .locals 0
    .param p1, "businessConnection"    # Lorg/drinkless/tdlib/TdApi$BusinessConnection;

    .line 21575
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21576
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateBusinessConnection;->connection:Lorg/drinkless/tdlib/TdApi$BusinessConnection;

    .line 21577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21581
    const v0, -0x79cd0b8a

    return v0
.end method
