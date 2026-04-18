.class public Lorg/drinkless/tdlib/TdApi$GetTextEntities;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetTextEntities"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TextEntities;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x145abc05


# instance fields
.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13776
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13777
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 13767
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13768
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetTextEntities;->text:Ljava/lang/String;

    .line 13769
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13773
    const v0, -0x145abc05

    return v0
.end method
