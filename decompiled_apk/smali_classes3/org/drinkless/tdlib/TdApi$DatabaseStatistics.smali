.class public Lorg/drinkless/tdlib/TdApi$DatabaseStatistics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DatabaseStatistics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42fd8cb0


# instance fields
.field public statistics:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11185
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11175
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11176
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DatabaseStatistics;->statistics:Ljava/lang/String;

    .line 11177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11181
    const v0, -0x42fd8cb0

    return v0
.end method
